package org.gonza.kotlinplayground.domain

class NameSplitter {
    companion object {
        private const val SPLIT_DELIMITER = ","
        private const val BLANK_STRING = ""

        fun split(value: String): List<String> {
            if (value.isEmpty()) {
                throw IllegalArgumentException("이름은 빈 문자열일 수 없습니다")
            }
            val nameList = value.split(SPLIT_DELIMITER).map { it.trim() }
            validate(nameList)

            return nameList
        }

        private fun validate(nameList: List<String>) {
            val nameSet = nameList.toSet()

            if (nameSet.contains(BLANK_STRING)) {
                throw IllegalArgumentException("이름은 빈 문자열일 수 없습니다")
            }

            if (nameSet.size != nameList.size) {
                throw IllegalArgumentException("이름은 중복될 수 없습니다")
            }
        }
    }
}
