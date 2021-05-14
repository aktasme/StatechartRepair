/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_1
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "IS_1.h"
//## event evBC()
#include "Default.h"
//## package Candidates::_5_IsolatedState

//## class IS_1
IS_1::IS_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

IS_1::~IS_1() {
}

bool IS_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void IS_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void IS_1::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus IS_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State B
    if(rootState_active == B)
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    A_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
            
        }
    return res;
}

void IS_1::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_1.cpp
*********************************************************************/
