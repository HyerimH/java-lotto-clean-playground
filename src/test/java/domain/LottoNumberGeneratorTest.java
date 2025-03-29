package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

  @Test
  @DisplayName("생성된 번호는 6개이다")
  void generateReturnsSixNumbers() {
    //Given
    LottoNumberGenerator generator = new LottoNumberGenerator();

    //When
    List<Integer> numbers = generator.generate();

    //Then
    assertThat(numbers).hasSize(6);
  }

  @Test
  @DisplayName("생성된 번호는 중복되지 않는다")
  void generateNumbersWithoutDuplicates() {
    // Given
    LottoNumberGenerator generator = new LottoNumberGenerator();

    // When
    List<Integer> numbers = generator.generate();

    // Then
    assertThat(numbers).doesNotHaveDuplicates();
  }

  @Test
  @DisplayName("생성된 번호는 정렬된다")
  void generateSortedNumbers() {
    // Given
    LottoNumberGenerator generator = new LottoNumberGenerator();

    // When
    List<Integer> numbers = generator.generate();

    // Then
    assertThat(numbers).isSorted();
  }
}
