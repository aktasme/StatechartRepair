/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "IS_3.h"
//## package _5_IsolatedState

//## class IS_3
IS_3::IS_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

IS_3::~IS_3() {
}

bool IS_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void IS_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void IS_3::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus IS_3::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    popNullTransition();
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
                    switch (A_subState) {
                        // State B
                        case B:
                        {
                            popNullTransition();
                        }
                        break;
                        // State C
                        case C:
                        {
                            popNullTransition();
                        }
                        break;
                        default:
                            break;
                    }
                    A_subState = OMNonState;
                    rootState_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
            
        }
        break;
        
        default:
            break;
    }
    return res;
}

void IS_3::A_entDef() {
    rootState_subState = A;
    pushNullTransition();
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_3.cpp
*********************************************************************/
