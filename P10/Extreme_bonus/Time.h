#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <stdexcept> // Include for std::out_of_range

class Time {
public:
    Time(); // Default constructor
    Time(int h, int m, int s); // Parameterized constructor

    // Overloaded operators for addition
    Time operator+(const Time& other) const;
    Time operator+(int sec) const; // Add seconds to Time
    Time& operator+=(const Time& other); // Add Time to this Time
    Time& operator+=(int sec); // Add seconds to this Time
    friend Time operator+(int sec, const Time& time); // Add seconds to Time, friend function

    // Overloaded increment operators
    Time& operator++();    // Prefix increment
    Time operator++(int);  // Postfix increment

    // Overloaded comparison operators
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;

    // Subscript operator for accessing hours, minutes, and seconds
    int& operator[](int index);
    int operator[](int index) const; // const version for read-only access

    // Friend functions for streaming
    friend std::ostream& operator<<(std::ostream& os, const Time& t);
    friend std::istream& operator>>(std::istream& is, Time& t);

private:
    int hours;
    int minutes;
    int seconds;
    void rationalize(); // Rationalization method
};

#endif // TIME_H

