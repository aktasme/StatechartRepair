/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_2
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_2.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "URS_2.h"
//## event evAB()
#include "Default.h"
//## package _5_UnreachableState

//## class URS_2
URS_2::URS_2(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

URS_2::~URS_2() {
}

bool URS_2::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void URS_2::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void URS_2::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus URS_2::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAB_Default_id))
                {
                    rootState_subState = B;
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
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDB_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
        }
        break;
        default:
            break;
    }
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_2.cpp
*********************************************************************/
