/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TWCWOE_1
//!	Generated Date	: Sat, 2, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TWCWOE_1.h"
//## event evStartAutoFocus()
#include "Default.h"
//## package _3_TransitionWithConditionWithoutEvent

//## class TWCWOE_1
TWCWOE_1::TWCWOE_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TWCWOE_1::~TWCWOE_1() {
}

bool TWCWOE_1::getIsAutoFocusFinished() const {
    return isAutoFocusFinished;
}

void TWCWOE_1::setIsAutoFocusFinished(bool p_isAutoFocusFinished) {
    isAutoFocusFinished = p_isAutoFocusFinished;
}

bool TWCWOE_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TWCWOE_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    AutoFocus_subState = OMNonState;
}

void TWCWOE_1::rootState_entDef() {
    {
        AutoFocus_entDef();
    }
}

IOxfReactive::TakeEventStatus TWCWOE_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State Idle
        case Idle:
        {
            if(IS_EVENT_TYPE_OF(evStartAutoFocus_Default_id))
                {
                    pushNullTransition();
                    AutoFocus_subState = AutoFocusInProgress;
                    rootState_active = AutoFocusInProgress;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State AutoFocusInProgress
        case AutoFocusInProgress:
        {
            if(IS_EVENT_TYPE_OF(OMNullEventId))
                {
                    //## transition 0 
                    if(isAutoFocusFinished)
                        {
                            popNullTransition();
                            AutoFocus_subState = Idle;
                            rootState_active = Idle;
                            res = eventConsumed;
                        }
                }
            
            
        }
        break;
        default:
            break;
    }
    return res;
}

void TWCWOE_1::AutoFocus_entDef() {
    rootState_subState = AutoFocus;
    AutoFocus_subState = Idle;
    rootState_active = Idle;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TWCWOE_1.cpp
*********************************************************************/
