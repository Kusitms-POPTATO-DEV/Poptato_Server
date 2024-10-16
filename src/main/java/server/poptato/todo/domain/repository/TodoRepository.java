package server.poptato.todo.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import server.poptato.todo.domain.entity.Todo;
import server.poptato.todo.domain.value.TodayStatus;
import server.poptato.todo.domain.value.Type;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository {
    void deleteAllByUserId(Long userId);
    // 미완료된 할 일 조회
    List<Todo> findByUserIdAndTypeAndTodayDateAndTodayStatusOrderByTodayOrderDesc(
            Long userId, Type type, LocalDate todayDate, TodayStatus todayStatus);

    // 완료된 할 일 조회
    List<Todo> findByUserIdAndTypeAndTodayDateAndTodayStatusOrderByCompletedDateTimeDesc(
            Long userId, Type type, LocalDate todayDate, TodayStatus todayStatus);

    // 백로그 목록 조회
    Page<Todo> findByUserIdAndTypeInOrderByBacklogOrderDesc(Long userId, List<Type> types, Pageable pageable);
}
