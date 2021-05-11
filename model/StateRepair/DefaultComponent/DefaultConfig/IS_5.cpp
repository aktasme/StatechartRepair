/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: IS_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\IS_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "IS_5.h"
//## event evAB()
#include "Default.h"
//## package _5_IsolatedState

//## class IS_5
IS_5::IS_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

IS_5::~IS_5() {
}

bool IS_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void IS_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    E_subState = OMNonState;
}

void IS_5::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus IS_5::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    rootState_subState = E;
                    E_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evAC_Default_id))
                {
                    rootState_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBD_Default_id))
                {
                    E_subState = D;
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

void IS_5::E_entDef() {
    rootState_subState = E;
    E_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\IS_5.cpp
*********************************************************************/
