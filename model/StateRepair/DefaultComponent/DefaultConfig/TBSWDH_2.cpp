/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_2
//!	Generated Date	: Sat, 2, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_2.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TBSWDH_2.h"
//## event evBC()
#include "Default.h"
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_2
TBSWDH_2::TBSWDH_2(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TBSWDH_2::~TBSWDH_2() {
}

bool TBSWDH_2::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TBSWDH_2::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void TBSWDH_2::rootState_entDef() {
    {
        rootState_subState = C;
        rootState_active = C;
    }
}

IOxfReactive::TakeEventStatus TBSWDH_2::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State C
    if(rootState_active == C)
        {
            if(IS_EVENT_TYPE_OF(evCB_Default_id))
                {
                    rootState_subState = A;
                    A_subState = B;
                    rootState_active = B;
                    res = eventConsumed;
                }
            
        }
    return res;
}

void TBSWDH_2::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_2.cpp
*********************************************************************/
