/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_4
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "IS_4.h"
//## event evAC()
#include "Default.h"
//## package _5_IsolatedState

//## class IS_4
IS_4::IS_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

IS_4::~IS_4() {
}

bool IS_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void IS_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void IS_4::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus IS_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State A
    if(rootState_active == A)
        {
            if(IS_EVENT_TYPE_OF(evAC_Default_id))
                {
                    rootState_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
        }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_4.cpp
*********************************************************************/
