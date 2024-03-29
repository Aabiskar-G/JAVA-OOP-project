#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"


class Circle : public Shape {
    double _radius;
public:
    Circle(double radius);
    std::string name() const override;
    double area() const override;
};

#endif // CIRCLE_H

