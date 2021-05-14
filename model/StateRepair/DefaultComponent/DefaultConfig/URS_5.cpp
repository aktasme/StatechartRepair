/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: URS_5
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\URS_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "URS_5.h"
//## event evBC()
#include "Default.h"
//## package _5_UnreachableState

//## class URS_5
URS_5::URS_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

URS_5::~URS_5() {
}

bool URS_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void URS_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    C_subState = OMNonState;
}

void URS_5::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus URS_5::rootState_processEvent() {
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
            if(IS_EVENT_TYPE_OF(evEF_Default_id))
                {
                    C_subState = OMNonState;
                    A_subState = F;
                    rootState_active = F;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evED_Default_id))
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
            if(IS_EVENT_TYPE_OF(evFG_Default_id))
                {
                    A_subState = G;
                    rootState_active = G;
                    res = eventConsumed;
                }
            else if(IS_EVENT_TYPE_OF(evFB_Default_id))
                {
                    A_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State G
        case G:
        {
            if(IS_EVENT_TYPE_OF(evGH_Default_id))
                {
                    A_subState = H;
                    rootState_active = H;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State H
        case H:
        {
            if(IS_EVENT_TYPE_OF(evHE_Default_id))
                {
                    A_subState = C;
                    C_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            
            
        }
        break;
        default:
            break;
    }
    return res;
}

void URS_5::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void URS_5::A_exit() {
    switch (A_subState) {
        // State C
        case C:
        {
            C_subState = OMNonState;
        }
        break;
        
        default:
            break;
    }
    A_subState = OMNonState;
    
}

void URS_5::C_entDef() {
    A_subState = C;
    C_subState = D;
    rootState_active = D;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\URS_5.cpp
*********************************************************************/
