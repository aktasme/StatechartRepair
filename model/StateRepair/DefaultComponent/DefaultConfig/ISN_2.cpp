/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_2
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_2.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "ISN_2.h"
//## event evA()
#include "Default.h"
//## package _4_InvalidStateName

//## class ISN_2
ISN_2::ISN_2(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

ISN_2::~ISN_2() {
}

bool ISN_2::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void ISN_2::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    state_0_subState = OMNonState;
}

void ISN_2::rootState_entDef() {
    {
        state_0_entDef();
    }
}

IOxfReactive::TakeEventStatus ISN_2::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State A
    if(rootState_active == A)
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    state_0_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
            
        }
    return res;
}

void ISN_2::state_0_entDef() {
    rootState_subState = state_0;
    state_0_subState = A;
    rootState_active = A;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_2.cpp
*********************************************************************/
