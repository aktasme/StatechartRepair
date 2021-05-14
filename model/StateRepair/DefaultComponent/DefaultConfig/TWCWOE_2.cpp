/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_2
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_2.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TWCWOE_2.h"
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_2
TWCWOE_2::TWCWOE_2(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TWCWOE_2::~TWCWOE_2() {
}

unsigned int TWCWOE_2::getX() const {
    return x;
}

void TWCWOE_2::setX(unsigned int p_x) {
    x = p_x;
}

bool TWCWOE_2::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TWCWOE_2::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void TWCWOE_2::rootState_entDef() {
    {
        pushNullTransition();
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus TWCWOE_2::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 1 
                    if(x == 0)
                        {
                            popNullTransition();
                            pushNullTransition();
                            rootState_subState = B;
                            rootState_active = B;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 2 
                    if(x == 1)
                        {
                            popNullTransition();
                            pushNullTransition();
                            rootState_subState = A;
                            rootState_active = A;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        default:
            break;
    }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_2.cpp
*********************************************************************/
