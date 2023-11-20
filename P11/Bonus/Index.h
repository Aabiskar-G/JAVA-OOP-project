#ifndef INDEX_H
#define INDEX_H

#include "Location.h"
#include <map>
#include <set>
#include <string>

class Index {
public:
    void add_word(const std::string& word, const Location& location);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);

private:
    typedef std::string Word;
    typedef std::set<Location> Locations;
    std::map<Word, Locations> _index;
};

#endif // INDEX_H

