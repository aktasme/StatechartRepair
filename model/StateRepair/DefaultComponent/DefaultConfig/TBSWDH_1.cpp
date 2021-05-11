/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_1
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_1.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TBSWDH_1.h"
//## event evBC()
#include "Default.h"
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_1
TBSWDH_1::TBSWDH_1(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TBSWDH_1::~TBSWDH_1() {
}

bool TBSWDH_1::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TBSWDH_1::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
}

void TBSWDH_1::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus TBSWDH_1::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    // State B
    if(rootState_active == B)
        {
            if(IS_EVENT_TYPE_OF(evBC_Default_id))
                {
                    // State B
                    
                    A_subState = OMNonState;
                    rootState_subState = C;
                    rootState_active = C;
                    res = eventConsumed;
                }
            
            
        }
    return res;
}

void TBSWDH_1::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_1.cpp
*********************************************************************/
