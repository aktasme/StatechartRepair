/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_5
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "ISN_5.h"
//## event evAB()
#include "Default.h"
//## package _4_InvalidStateName

//## class ISN_5
ISN_5::ISN_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

ISN_5::~ISN_5() {
}

bool ISN_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void ISN_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void ISN_5::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus ISN_5::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A_A:
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    pushNullTransition();
                    A_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    popNullTransition();
                    A_subState = state_1;
                    rootState_active = state_1;
                    res = eventConsumed;
                }
            
            
        }
        break;
        
        default:
            break;
    }
    return res;
}

void ISN_5::A_entDef() {
    rootState_subState = A;
    A_subState = A_A;
    rootState_active = A_A;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_5.cpp
*********************************************************************/
