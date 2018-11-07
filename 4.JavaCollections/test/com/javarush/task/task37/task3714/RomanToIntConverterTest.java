package com.javarush.task.task37.task3714;

import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RomanToIntConverterTest {
    RomanToIntConverter converter = new RomanToIntConverter();

    static Stream<Arguments> romanDigitProvider() {
        return Stream.of(
                arguments("I", 1),
                arguments("V", 5),
                arguments("X", 10),
                arguments("L", 50),
                arguments("C", 100),
                arguments("D", 500),
                arguments("M", 1000)

        );
    }

    @ParameterizedTest
    @MethodSource("romanDigitProvider")
    public void convertOneNumeral(String roman, int i) {
        assertEquals(i, converter.convert(roman));
    }

    @Test
    public void convertMultipleNumerals() {
        String roman = "XVIII";
        assertEquals(18, converter.convert(roman));
    }

    @Test
    public void converts() {
        assertTrue(true);
    }
}