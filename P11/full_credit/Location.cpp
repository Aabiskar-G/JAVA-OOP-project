#include "Location.h"

Location::Location(const std::string& filename, int line) : _filename(filename), _line(line) {}

bool Location::operator<(const Location& rhs) const {
    if (_filename < rhs._filename) return true;
    if (_filename > rhs._filename) return false;
    return _line < rhs._line;
}

bool Location::operator>(const Location& rhs) const {
    return rhs < *this;
}

bool Location::operator<=(const Location& rhs) const {
    return !(rhs < *this);
}

bool Location::operator>=(const Location& rhs) const {
    return !(*this < rhs);
}

bool Location::operator==(const Location& rhs) const {
    return _filename == rhs._filename && _line == rhs._line;
}

bool Location::operator!=(const Location& rhs) const {
    return !(*this == rhs);
}

std::ostream& operator<<(std::ostream& os, const Location& loc) {
    os << loc._filename << " line " << loc._line;
    return os;
}

