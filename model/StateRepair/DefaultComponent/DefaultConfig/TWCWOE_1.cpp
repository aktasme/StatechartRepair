/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TWCWOE_1.h"
//## event evStartAutoFocus()
#include "Default.h"
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_1
TWCWOE_1::TWCWOE_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TWCWOE_1::~TWCWOE_1() {
}

bool TWCWOE_1::getX() const {
    return x;
}

void TWCWOE_1::setX(bool p_x) {
    x = p_x;
}

bool TWCWOE_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TWCWOE_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void TWCWOE_1::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus TWCWOE_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    pushNullTransition();
                    A_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 0 
                    if(x == true)
                        {
                            popNullTransition();
                            A_subState = B;
                            rootState_active = B;
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

void TWCWOE_1::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.cpp
*********************************************************************/
