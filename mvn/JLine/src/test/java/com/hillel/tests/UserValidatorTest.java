package com.hillel.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hillel.tests.user.User;
import com.hillel.tests.user.UserValidator;
import com.hillel.tests.user.exceptions.AgeException;
import com.hillel.tests.user.exceptions.EmailException;
import com.hillel.tests.user.exceptions.PhoneValidationException;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("User validator test")
class UserValidatorTest {

}
