/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_4
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TWCWOE_4.h"
//## event evB()
#include "Default.h"
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_4
TWCWOE_4::TWCWOE_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TWCWOE_4::~TWCWOE_4() {
}

unsigned int TWCWOE_4::getX() const {
    return x;
}

void TWCWOE_4::setX(unsigned int p_x) {
    x = p_x;
}

bool TWCWOE_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TWCWOE_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void TWCWOE_4::rootState_entDef() {
    {
        pushNullTransition();
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus TWCWOE_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    popNullTransition();
                    pushNullTransition();
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 3 
                    if(x == 1)
                        {
                            popNullTransition();
                            pushNullTransition();
                            rootState_subState = B;
                            rootState_active = B;
                            res = eventConsumed;
                        }
                }
            else if(IS_EVENT_TYPE_OF(evB_Default_id))
                {
                    //## transition 2 
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
                    //## transition 4 
                    if(x == 2)
                        {
                            popNullTransition();
                            pushNullTransition();
                            rootState_subState = C;
                            rootState_active = C;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 5 
                    if(x == 1)
                        {
                            popNullTransition();
                            pushNullTransition();
                            rootState_subState = D;
                            rootState_active = D;
                            res = eventConsumed;
                        }
                }
            
        }
        break;
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 6 
                    if(x == 2)
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
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_4.cpp
*********************************************************************/
