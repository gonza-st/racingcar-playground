package org.gonza.kotlinplayground

import org.assertj.core.api.Assertions.*
import org.gonza.kotlinplayground.domain.car.MoveStrategy
import org.gonza.kotlinplayground.presentation.RacingCarGameValidator
import org.gonza.kotlinplayground.presentation.ui.InputView
import org.gonza.kotlinplayground.presentation.ui.TestOutputErrorView
import org.gonza.kotlinplayground.presentation.ui.TestOutputViewAdapter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RacingCarGameRunnerTest {
    private val nullTestInputView = object : InputView {
        var callCount = 0
        override fun read(): String? {
            callCount++
            return when (callCount) {
                1 -> null // 잘못된 차량이름 입력 케이스
                2 -> "test" // 올바른 차량이름 입력 케이스
                else -> "3" // 올바른 횟수 입력
            }
        }
    }

    private val emptyTestInputView = object : InputView {
        var callCount = 0
        override fun read(): String {
            callCount++
            return when (callCount) {
                1 -> "" // 잘못된 차량이름 입력 케이스
                2 -> "test" // 올바른 차량이름 입력 케이스
                else -> "3" // 올바른 횟수 입력
            }
        }
    }

    private val duplicatedTestInputView = object : InputView {
        var callCount = 0
        override fun read(): String {
            callCount++
            return when (callCount) {
                1 -> "test,test" // 잘못된 차량이름 입력 케이스
                2 -> "test" // 올바른 차량이름 입력 케이스
                else -> "3" // 올바른 횟수 입력
            }
        }
    }

    private val carNameLengthOverTestInputView = object : InputView {
        var callCount = 0
        override fun read(): String {
            callCount++
            return when (callCount) {
                1 -> "123456789" // 잘못된 차량이름 입력 케이스
                2 -> "test" // 올바른 차량이름 입력 케이스
                else -> "3" // 올바른 횟수 입력
            }
        }
    }

    private val testMoveStrategy = MoveStrategy { true }

    @BeforeEach
    fun init() {
        nullTestInputView.callCount = 0
        emptyTestInputView.callCount = 0
        duplicatedTestInputView.callCount = 0
        carNameLengthOverTestInputView.callCount = 0
    }

    @Test
    fun `게임이 시작될때 이름이 없다면 게임이 다시 실행된다`() {
        val errorView = TestOutputErrorView()
        val outputView = TestOutputViewAdapter(errorView)
        val validator = RacingCarGameValidator()
        val nullNameRacingCarGameRunner = RacingCarGameRunner(
            output = outputView,
            input = nullTestInputView,
            validator = validator,
            moveStrategy = testMoveStrategy
        )
        val emptyNameRacingCarGameRunner = RacingCarGameRunner(
            output = outputView,
            input = emptyTestInputView,
            validator = validator,
            moveStrategy = testMoveStrategy
        )

        assertDoesNotThrow { nullNameRacingCarGameRunner.run() }
        assertDoesNotThrow { emptyNameRacingCarGameRunner.run() }
        assertThat(errorView.printErrorCount).isGreaterThan(0)
        assertThat(nullTestInputView.callCount).isGreaterThan(1)
        assertThat(emptyTestInputView.callCount).isGreaterThan(1)
    }

    @Test
    fun `게임이 시작될때 이름이 중복된다면 게임이 다시 실행된다`() {
        val errorView = TestOutputErrorView()
        val outputView = TestOutputViewAdapter(errorView)
        val validator = RacingCarGameValidator()
        val duplicatedNameRacingCarGameRunner = spy(RacingCarGameRunner(
            output = outputView,
            input = duplicatedTestInputView,
            validator = validator,
            moveStrategy = testMoveStrategy
        ))

        assertDoesNotThrow { duplicatedNameRacingCarGameRunner.run() }
        verify(duplicatedNameRacingCarGameRunner, times(2)).run()
        assertThat(errorView.printErrorCount > 0)
        assertThat(duplicatedTestInputView.callCount > 1)
    }

    @Test
    fun `게임이 시작될때 이름이 5글자를 초과하면 게임이 다시 실행된다`() {
        val errorView = TestOutputErrorView()
        val outputView = TestOutputViewAdapter(errorView)
        val validator = RacingCarGameValidator()
        val nameLengthOverRacingCarGameRunner = spy(RacingCarGameRunner(
            output = outputView,
            input = carNameLengthOverTestInputView,
            validator = validator,
            moveStrategy = testMoveStrategy
        ))

        assertDoesNotThrow { nameLengthOverRacingCarGameRunner.run() }
        verify(nameLengthOverRacingCarGameRunner, times(2)).run()
        assertThat(errorView.printErrorCount > 0)
        assertThat(carNameLengthOverTestInputView.callCount > 1)
    }
}
