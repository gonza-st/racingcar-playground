package org.gonza.kotlinplayground

data class TodoItem(
    val content: String,
    val completed: Boolean = false,
    val priority: Priority = Priority.MEDIUM //추가
) {
    //init 블록 추가: 객체 생성 시 초기화 검증을 수행
    init {
        require(content.isNotBlank()) { "할 일 내용은 비어있을 수 없습니다." }
    }
}


