/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: TBSWDH_3
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_3.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "TBSWDH_3.h"
//## event evBC()
#include "Default.h"
//## package _2_TransitionBetweenStatesWithDifferentHierarchy

//## class TBSWDH_3
TBSWDH_3::TBSWDH_3(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

TBSWDH_3::~TBSWDH_3() {
}

bool TBSWDH_3::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void TBSWDH_3::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    C_subState = OMNonState;
}

void TBSWDH_3::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus TBSWDH_3::rootState_processEvent() {
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
        // State D
        case D:
        {
            if(IS_EVENT_TYPE_OF(evDE_Default_id))
                {
                    C_subState = E;
                    rootState_active = E;
                    res = eventConsumed;
                }
            
            
        }
        break;
        // State E
        case E:
        {
            if(IS_EVENT_TYPE_OF(evEB_Default_id))
                {
                    C_subState = OMNonState;
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

void TBSWDH_3::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void TBSWDH_3::C_entDef() {
    A_subState = C;
    C_subState = D;
    rootState_active = D;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\TBSWDH_3.cpp
*********************************************************************/
