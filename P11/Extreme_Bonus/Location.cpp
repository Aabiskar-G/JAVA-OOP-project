#include "Location.h"

std::string Location::last_filename = "";

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
    if (loc._filename != Location::last_filename) {
        if (!Location::last_filename.empty()) {
            os << ", "; 
        }
        os << loc._filename << " line ";
        Location::last_filename = loc._filename;
    } else {
        os << ", "; 
    }
    os << loc._line;
    return os;
}

void Location::next_word(){
    last_filename =""; 
}
