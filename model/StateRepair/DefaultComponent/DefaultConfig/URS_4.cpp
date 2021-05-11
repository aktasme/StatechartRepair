/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_4
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "URS_4.h"
//## event evBC()
#include "Default.h"
//## package _6_UnreachableState

//## class URS_4
URS_4::URS_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

URS_4::~URS_4() {
}

bool URS_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void URS_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    C_subState = OMNonState;
}

void URS_4::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus URS_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    C_entDef();
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State E
        case E:
        {
            if(IS_EVENT_TYPE_OF(evED_Default_id))
                {
                    C_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State F
        case F:
        {
            if(IS_EVENT_TYPE_OF(evFB_Default_id))
                {
                    A_subState = B;
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

void URS_4::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void URS_4::C_entDef() {
    A_subState = C;
    C_subState = D;
    rootState_active = D;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_4.cpp
*********************************************************************/
