/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_3
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "ISN_3.h"
//## event evB()
#include "Default.h"
//## package _4_InvalidStateName

//## class ISN_3
ISN_3::ISN_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

ISN_3::~ISN_3() {
}

bool ISN_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void ISN_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void ISN_3::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus ISN_3::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State state_3
    if(rootState_active == state_3)
        {
            if(IS_EVENT_TYPE_OF(evB_Default_id))
                {
                    A_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
            
        }
    return res;
}

void ISN_3::A_entDef() {
    rootState_subState = A;
    A_subState = state_3;
    rootState_active = state_3;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_3.cpp
*********************************************************************/
