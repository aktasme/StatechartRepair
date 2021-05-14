/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_3
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "NC_3.h"
//## event evA()
#include "Default.h"
//## package _6_NestedConditions

//## class NC_3
NC_3::NC_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

NC_3::~NC_3() {
}

int NC_3::getX() const {
    return x;
}

void NC_3::setX(int p_x) {
    x = p_x;
}

int NC_3::getY() const {
    return y;
}

void NC_3::setY(int p_y) {
    y = p_y;
}

bool NC_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void NC_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void NC_3::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus NC_3::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State A
    if(rootState_active == A)
        {
            res = A_handleEvent();
        }
    return res;
}

IOxfReactive::TakeEventStatus NC_3::ATakeevA() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    //## transition 2 
    if(x == 1)
        {
            //## transition 8 
            if(y == 1)
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
        }
    else
        {
            //## transition 3 
            if(x == 2)
                {
                    rootState_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            else
                {
                    //## transition 4 
                    if(x == 3)
                        {
                            //## transition 7 
                            if(y == 1)
                                {
                                    rootState_subState = D;
                                    rootState_active = D;
                                    res = eventConsumed;
                                }
                            else
                                {
                                    rootState_subState = A;
                                    rootState_active = A;
                                    res = eventConsumed;
                                }
                        }
                }
        }
    return res;
}

IOxfReactive::TakeEventStatus NC_3::A_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evA_Default_id))
        {
            res = ATakeevA();
        }
    
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_3.cpp
*********************************************************************/
