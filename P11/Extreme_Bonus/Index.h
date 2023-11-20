#ifndef INDEX_H
#define INDEX_H

#include "Location.h"
#include <string>
#include <iostream>
#include <map>

class Index {
public:
    void add_word(const std::string& word, const Location& location);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);

private:
    typedef std::string Word;
    typedef std::multimap<Word, Location> WordLocations;
    WordLocations _index;
};

#endif // INDEX_H

