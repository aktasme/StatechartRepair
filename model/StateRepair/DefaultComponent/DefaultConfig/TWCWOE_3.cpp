/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_3
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TWCWOE_3.h"
//## event evAB()
#include "Default.h"
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_3
TWCWOE_3::TWCWOE_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TWCWOE_3::~TWCWOE_3() {
}

unsigned int TWCWOE_3::getX() const {
    return x;
}

void TWCWOE_3::setX(unsigned int p_x) {
    x = p_x;
}

bool TWCWOE_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TWCWOE_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void TWCWOE_3::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus TWCWOE_3::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    pushNullTransition();
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    popNullTransition();
                    rootState_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 5 
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
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(evCD_Default_id))
                {
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
        }
        break;
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDA_Default_id))
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
            
        }
        break;
        default:
            break;
    }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_3.cpp
*********************************************************************/
