#include "Time.h"

Time::Time(int h, int m, int s) : hours(h), minutes(m), seconds(s) {
    rationalize();
}

void Time::rationalize() {
    // Adjust seconds and minutes
    minutes += seconds / 60;
    seconds %= 60;
    if (seconds < 0) {
        seconds += 60;
        minutes--;
    }

    // Adjust hours
    hours += minutes / 60;
    minutes %= 60;
    if (minutes < 0) {
        minutes += 60;
        hours--;
    }

    // Adjust hours to 24-hour format
    hours %= 24;
    if (hours < 0) {
        hours += 24;
    }
}

Time Time::operator+(const Time& other) const {
    return Time(hours + other.hours, minutes + other.minutes, seconds + other.seconds);
}

Time& Time::operator++() {
    seconds++;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp = *this;
    ++(*this);
    return temp;
}

bool Time::operator==(const Time& other) const {
    return hours == other.hours && minutes == other.minutes && seconds == other.seconds;
}

bool Time::operator!=(const Time& other) const {
    return !(*this == other);
}

bool Time::operator<(const Time& other) const {
    return (hours < other.hours) ||
           (hours == other.hours && minutes < other.minutes) ||
           (hours == other.hours && minutes == other.minutes && seconds < other.seconds);
}

bool Time::operator>(const Time& other) const {
    return other < *this;
}

bool Time::operator<=(const Time& other) const {
    return !(other < *this);
}

bool Time::operator>=(const Time& other) const {
    return !(*this < other);
}

std::ostream& operator<<(std::ostream& os, const Time& t) {
    os << (t.hours < 10 ? "0" : "") << t.hours << ":"
       << (t.minutes < 10 ? "0" : "") << t.minutes << ":"
       << (t.seconds < 10 ? "0" : "") << t.seconds;
    return os;
}

std::istream& operator>>(std::istream& is, Time& t) {
    char delim1, delim2;
    is >> t.hours >> delim1 >> t.minutes >> delim2 >> t.seconds;
    if (delim1 != ':' || delim2 != ':' || !is) {
        is.setstate(std::ios::failbit);
    }
    t.rationalize();
    return is;
}

