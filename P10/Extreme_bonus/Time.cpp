#include "Time.h"
#include <iostream>
#include <stdexcept> // Required for std::out_of_range

// Default constructor
Time::Time() : hours(0), minutes(0), seconds(0) {}

// Parameterized constructor
Time::Time(int h, int m, int s) : hours(h), minutes(m), seconds(s) {
    rationalize();
}

// Rationalize the time to ensure all fields are within correct limits
void Time::rationalize() {
    if (seconds >= 60) {
        minutes += seconds / 60;
        seconds %= 60;
    } else if (seconds < 0) {
        minutes--;
        seconds += 60;
    }

    if (minutes >= 60) {
        hours += minutes / 60;
        minutes %= 60;
    } else if (minutes < 0) {
        hours--;
        minutes += 60;
    }

    if (hours >= 24) {
        hours %= 24;
    } else if (hours < 0) {
        hours += 24;
    }
}

// Addition of two Time objects
Time Time::operator+(const Time& other) const {
    Time result = *this;
    result.seconds += other.seconds;
    result.minutes += other.minutes;
    result.hours += other.hours;
    result.rationalize();
    return result;
}

// Addition of Time object and seconds
Time Time::operator+(int sec) const {
    Time result = *this;
    result.seconds += sec;
    result.rationalize();
    return result;
}

// Compound assignment of Time object and seconds
Time& Time::operator+=(const Time& other) {
    this->seconds += other.seconds;
    this->minutes += other.minutes;
    this->hours += other.hours;
    this->rationalize();
    return *this;
}

// Compound assignment of Time object and integer seconds
Time& Time::operator+=(int sec) {
    this->seconds += sec;
    this->rationalize();
    return *this;
}

// Prefix increment
Time& Time::operator++() {
    *this += 1;
    return *this;
}

// Postfix increment
Time Time::operator++(int) {
    Time temp = *this;
    ++*this;
    return temp;
}

// Comparison operators
bool Time::operator==(const Time& other) const {
    return (hours == other.hours) && (minutes == other.minutes) && (seconds == other.seconds);
}

bool Time::operator!=(const Time& other) const {
    return !(*this == other);
}

bool Time::operator<(const Time& other) const {
    if (hours < other.hours) return true;
    if (hours == other.hours && minutes < other.minutes) return true;
    if (hours == other.hours && minutes == other.minutes && seconds < other.seconds) return true;
    return false;
}

bool Time::operator>(const Time& other) const {
    return other < *this;
}

bool Time::operator<=(const Time& other) const {
    return !(*this > other);
}

bool Time::operator>=(const Time& other) const {
    return !(*this < other);
}

// Subscript operator for non-const objects
int& Time::operator[](int index) {
    switch (index) {
        case 0: return hours;
        case 1: return minutes;
        case 2: return seconds;
        default: throw std::out_of_range("Index out of range: must be 0, 1, or 2.");
    }
}

// Subscript operator for const objects
int Time::operator[](int index) const {
    switch (index) {
        case 0: return hours;
        case 1: return minutes;
        case 2: return seconds;
        default: throw std::out_of_range("Index out of range: must be 0, 1, or 2.");
    }
}

// Stream insertion operator
std::ostream& operator<<(std::ostream& os, const Time& t) {
    os.fill('0');
    os.width(2);
    os << t.hours << ':';
    os.width(2);
    os << t.minutes << ':';
    os.width(2);
    os << t.seconds;
    return os;
}

// Stream extraction operator
std::istream& operator>>(std::istream& is, Time& t) {
    char delim1, delim2;
    is >> t.hours >> delim1 >> t.minutes >> delim2 >> t.seconds;
    if (!is || delim1 != ':' || delim2 != ':') {
        is.setstate(std::ios::failbit);
    } else {
        t.rationalize();
    }
    return is;
}

