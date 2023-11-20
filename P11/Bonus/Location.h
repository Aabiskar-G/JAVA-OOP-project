#ifndef LOCATION_H
#define LOCATION_H

#include <string>
#include <iostream>

class Location {
public:
    Location(const std::string& filename, int line);
    bool operator<(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;
    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;

    friend std::ostream& operator<<(std::ostream& os, const Location& loc);
    static void next_word();

private:
    std::string _filename;
    int _line;
 
    static std::string last_filename;
};

#endif // LOCATION_H

