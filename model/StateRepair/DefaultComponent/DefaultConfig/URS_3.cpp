/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "URS_3.h"
//## event evDC()
#include "Default.h"
//## package _6_UnreachableState

//## class URS_3
URS_3::URS_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

URS_3::~URS_3() {
}

bool URS_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void URS_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void URS_3::rootState_entDef() {
    {
        rootState_subState = A;
        rootState_active = A;
    }
}

IOxfReactive::TakeEventStatus URS_3::rootState_processEvent() {
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
            if(IS_EVENT_TYPE_OF(evDA_Default_id))
                {
                    rootState_subState = A;
                    rootState_active = A;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evDB_Default_id))
                {
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evDC_Default_id))
                {
                    rootState_subState = C;
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

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_3.cpp
*********************************************************************/
