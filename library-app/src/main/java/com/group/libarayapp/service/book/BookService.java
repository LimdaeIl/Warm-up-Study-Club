package com.group.libarayapp.service.book;

import com.group.libarayapp.domain.book.Book;
import com.group.libarayapp.domain.user.User;
import com.group.libarayapp.domain.user.UserRepository;
import com.group.libarayapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libarayapp.dto.book.request.BookCreateRequest;
import com.group.libarayapp.dto.book.request.BookLoanRequest;
import com.group.libarayapp.dto.book.request.BookReturnRequest;
import com.group.libarayapp.repository.book.BookRepository;
import com.group.libarayapp.repository.user.UserLoanHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository,
                       UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        Book book = new Book(request.getName());
        bookRepository.save(book);
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. 대출 기록 정보를 확인해서 대출중인지 확인합니다.
        // 3. 만약에 확인했는데 대충 중이라면 예외 발생시킵니다.
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("진작 대출되어 있는 책입니다.");
        }

        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory 를 저장
        UserLoanHistory userLoanHistory = new UserLoanHistory(user, book.getName());
        userLoanHistoryRepository.save(userLoanHistory);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 1. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 2. 유저 아이디로 대출 기록 찾는다.
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalAccessError::new);
        history.doReturn();

        userLoanHistoryRepository.save(history);
    }
}
