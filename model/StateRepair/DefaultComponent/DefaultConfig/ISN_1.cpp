/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: ISN_1
//!	Generated Date	: Thu, 14, May 2020  
	File Path	: DefaultComponent\DefaultConfig\ISN_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "ISN_1.h"
//## event evSetFOVInd()
#include "Default.h"
//## package _4_InvalidStateName

//## class ISN_1
ISN_1::ISN_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

ISN_1::~ISN_1() {
}

bool ISN_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void ISN_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    FOVAdjusment_subState = OMNonState;
}

void ISN_1::rootState_entDef() {
    {
        FOVAdjusment_entDef();
    }
}

IOxfReactive::TakeEventStatus ISN_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State InitialFOV
        case InitialFOV:
        {
            if(IS_EVENT_TYPE_OF(evFindNearestFOV_Default_id))
                {
                    FOVAdjusment_subState = state_659;
                    rootState_active = state_659;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State state_659
        case state_659:
        {
            if(IS_EVENT_TYPE_OF(evFinishFOVAdjustment_Default_id))
                {
                    FOVAdjusment_subState = state_660;
                    rootState_active = state_660;
                    res = eventConsumed;
                }
            
            
        }
        break;
        
        default:
            break;
    }
    return res;
}

void ISN_1::FOVAdjusment_entDef() {
    rootState_subState = FOVAdjusment;
    FOVAdjusment_subState = InitialFOV;
    rootState_active = InitialFOV;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\ISN_1.cpp
*********************************************************************/
