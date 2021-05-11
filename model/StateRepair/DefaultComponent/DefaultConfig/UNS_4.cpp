/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: UNS_4
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\UNS_4.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "UNS_4.h"
//## event evBC()
#include "Default.h"
//## package _8_UnnecessaryState

//## class UNS_4
UNS_4::UNS_4(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

UNS_4::~UNS_4() {
}

bool UNS_4::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void UNS_4::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
}

void UNS_4::rootState_entDef() {
    {
        pushNullTransition();
        rootState_subState = A;
        rootState_active = A;
        //#[ state A.(Entry) 
        printf("A: Enter!\n");
        //#]
    }
}

IOxfReactive::TakeEventStatus UNS_4::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State A
        case A:
        {
            if(IS_EVENT_TYPE_OF(evAA_Default_id))
                {
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    popNullTransition();
                    rootState_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
        }
        break;
        // State B
        case B:
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    rootState_subState = C;
                    rootState_active = C;
                    //#[ state C.(Entry) 
                    printf("B: Enter!\n");
                    //#]
                    res = eventConsumed;
                }
            
        }
        break;
        // State C
        case C:
        {
            if(IS_EVENT_TYPE_OF(evCC_Default_id))
                {
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
	File Path	: DefaultComponent\DefaultConfig\UNS_4.cpp
*********************************************************************/
