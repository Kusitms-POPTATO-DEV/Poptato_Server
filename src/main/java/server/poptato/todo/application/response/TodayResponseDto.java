package server.poptato.todo.application.response;

import lombok.Getter;
import server.poptato.todo.domain.entity.Todo;
import server.poptato.todo.domain.value.TodayStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
public class TodayResponseDto {
    Long todoId;
    String content;
    TodayStatus todayStatus;
    boolean isBookmark;
    Integer dDay;
    LocalDate deadline;

    public TodayResponseDto(Todo todo) {
        this.todoId = todo.getId();
        this.content = todo.getContent();
        this.todayStatus = todo.getTodayStatus();
        this.isBookmark = todo.isBookmark();
        this.deadline = todo.getDeadline();

        if (todo.getDeadline() != null && todo.getTodayDate() != null) {
            this.dDay = (int) ChronoUnit.DAYS.between(todo.getTodayDate(), todo.getDeadline());
        } else {
            // 마감 기한을 계산할 수 없는 경우 NULL
            this.dDay = null;
        }
    }
}
