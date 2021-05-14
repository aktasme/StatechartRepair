/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_4
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "ISN_4.h"
//## event evB()
#include "Default.h"
//## package _4_InvalidStateName

//## class ISN_4
ISN_4::ISN_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

ISN_4::~ISN_4() {
}

bool ISN_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void ISN_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void ISN_4::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus ISN_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State B
    if(rootState_active == B)
        {
            if(IS_EVENT_TYPE_OF(evB_Default_id))
                {
                    A_subState = state_1;
                    rootState_active = state_1;
                    res = eventConsumed;
                }
            
            
        }
    return res;
}

void ISN_4::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_4.cpp
*********************************************************************/
