package com.hillel.tests.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class UserCalculateTest {

    @Test
    void getFullName(){
        UserCalculate userCalculate = new UserCalculate();

        User user = new User()
            .setName("Oleksandr");


        assertEquals("Oleksandr Oleksandr", userCalculate.calculateFullName(user));
    }

    @Test
    void getFullName_mock(){
        UserCalculate userCalculate = mock(UserCalculate.class);

        User user = new User()
            .setName("Oleksandr");

        when(userCalculate.calculateFullName(any())).thenReturn("Oleksandr Oleksandr");
        when(userCalculate.calculateFullName(null)).thenReturn("");
        assertEquals("Oleksandr Oleksandr", userCalculate.calculateFullName(user));
        assertEquals("", userCalculate.calculateFullName(null));

        verify(userCalculate, times(2)).calculateFullName(any());
        verify(userCalculate, times(1)).calculateFullName(null);
    }

    @Test
    void getFullName_mock_seq(){
        UserCalculate userCalculate = mock(UserCalculate.class);

        User user = new User()
            .setName("Oleksandr");

        when(userCalculate.calculateFullName(any()))
            .thenReturn("1")
            .thenReturn("2")
            .thenReturn("3")
            .thenReturn("4");

        assertEquals("1", userCalculate.calculateFullName(user));
        assertEquals("2", userCalculate.calculateFullName(user));
        assertEquals("3", userCalculate.calculateFullName(user));
        assertEquals("4", userCalculate.calculateFullName(user));

        verify(userCalculate, times(4)).calculateFullName(any());


    }
}
