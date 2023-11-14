#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time {
public:
    Time(); // Default constructor
    Time(int h, int m, int s); // Parameterized constructor

    // Overloaded operators
    Time operator+(const Time& other) const;
    Time operator+(int sec) const; // Add seconds to Time
    friend Time operator+(int sec, const Time& time); // Add Time to seconds
    Time& operator++();    // Prefix increment
    Time operator++(int);  // Postfix increment
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;

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


