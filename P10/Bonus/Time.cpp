#include "Time.h"

Time::Time() : hours(0), minutes(0), seconds(0) {
    // Body is empty as member initialization list does everything needed
}

Time::Time(int h, int m, int s) : hours(h), minutes(m), seconds(s) {
    rationalize();
}

void Time::rationalize() {
    minutes += seconds / 60;
    seconds %= 60;
    if (seconds < 0) {
        seconds += 60;
        minutes--;
    }

    hours += minutes / 60;
    minutes %= 60;
    if (minutes < 0) {
        minutes += 60;
        hours--;
    }

    hours %= 24;
    if (hours < 0) {
        hours += 24;
    }
}

Time Time::operator+(const Time& other) const {
    return Time(hours + other.hours, minutes + other.minutes, seconds + other.seconds);
}

Time Time::operator+(int sec) const {
    return Time(hours, minutes, seconds + sec);
}

Time operator+(int sec, const Time& time) {
    return Time(time.hours, time.minutes, time.seconds + sec);
}

Time& Time::operator++() {
    ++seconds;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp(*this);
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
    if (hours < other.hours) return true;
    if (hours > other.hours) return false;
    if (minutes < other.minutes) return true;
    if (minutes > other.minutes) return false;
    return seconds < other.seconds;
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
    } else {
        t.rationalize();
    }
    return is;
}


