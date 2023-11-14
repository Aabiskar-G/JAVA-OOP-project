#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <stdexcept>

class Time {
public:
    // Constructor with default values
    Time(int h = 0, int m = 0, int s = 0);

    // Rationalization method
    void rationalize();

    // Overloaded subscript operator for const and non-const instances
    int operator[](int index) const;
    int& operator[](int index);

    // Overloaded operators
    Time operator+(const Time& other) const;
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
};

#endif // TIME_H

