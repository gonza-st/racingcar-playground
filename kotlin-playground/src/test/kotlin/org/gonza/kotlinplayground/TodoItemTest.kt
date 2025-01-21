package org.gonza.kotlinplayground

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TodoItemTest {

    @Test
    @DisplayName("할 일 항목 생성 시 기본값이 제대로 설정되어야 한다")
    fun createWithDefaultValues() {
        val todo = TodoItem("장보기")
        assertEquals("장보기", todo.content)
        assertFalse(todo.completed)
    }

    @Test
    @DisplayName("할 일 내용이 비어있으면 예외가 발생해야 한다")
    fun throwForEmptyContent() {
        assertThrows<IllegalArgumentException> {
            TodoItem("")
        }
    }

    @Test
    @DisplayName("할 일 내용을 수정할 수 있어야 한다")
    fun updateContent() {
        val todo = TodoItem("장보기")
        val updatedTodo = todo.copy(content = "마트 가서 장보기")
        assertEquals("마트 가서 장보기", updatedTodo.content)
        assertEquals(todo.completed, updatedTodo.completed)
    }

    @Test
    @DisplayName("할 일의 완료 상태를 변경할 수 있어야 한다")
    fun updateCompletionStatus() {
        val todo = TodoItem("장보기")
        val completedTodo = todo.copy(completed = true)
        assertEquals(todo.content, completedTodo.content)
        assertEquals(true, completedTodo.completed)
    }

    @Test
    @DisplayName("할 일 생성 시 우선순위를 지정할 수 있어야 한다")
    fun createWithPriority() {
        val todo = TodoItem("장보기", priority = Priority.HIGH)
        assertEquals(Priority.HIGH, todo.priority)
    }

    @Test
    @DisplayName("우선순위를 지정하지 않으면 기본값은 MEDIUM이어야 한다")
    fun defaultPriorityIsMedium() {
        val todo = TodoItem("장보기")
        assertEquals(Priority.MEDIUM, todo.priority)
    }

    @Test
    @DisplayName("할 일 내용을 빈 문자열로 수정할 수 없다")
    fun throwForEmptyUpdateContent() {
        val todo = TodoItem("장보기")
        assertThrows<IllegalArgumentException> {
            todo.copy(content = "")
        }
    }

    @Test
    @DisplayName("할 일 내용이 공백으로만 이루어져있으면 예외가 발생해야 한다")
    fun throwForWhitespaceContent() {
        assertThrows<IllegalArgumentException> {
            TodoItem(" ")
        }
    }

    @Test
    @DisplayName("할 일 내용이 최대 길이를 초과하면 예외가 발생해야 한다")
    fun throwForExceedingMaxLength() {
        val maxLength = 5
        val contentExceedingMaxLength = "A".repeat(maxLength + 1)
        assertThrows<IllegalArgumentException> {
            TodoItem(contentExceedingMaxLength)
        }
    }
}