/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_1
//!	Generated Date	: Sat, 2, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "URS_1.h"
//## event evDC()
#include "Default.h"
//## package _6_UnreachableState

//## class URS_1
URS_1::URS_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

URS_1::~URS_1() {
}

bool URS_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void URS_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void URS_1::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus URS_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    A_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDC_Default_id))
                {
                    A_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
            
        }
        break;
        default:
            break;
    }
    return res;
}

void URS_1::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_1.cpp
*********************************************************************/