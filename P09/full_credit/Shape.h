#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape {
public:
    virtual ~Shape() = default;
    virtual std::string name() const ; 
    virtual double area() const;
    virtual std::string to_string() const;
};

#endif // SHAPE_H

