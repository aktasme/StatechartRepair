/********************************************************************
	Rhapsody	: 8.4 
	Login		: diego
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: NC_5
//!	Generated Date	: Mon, 11, May 2020  
	File Path	: DefaultComponent\DefaultConfig\NC_5.cpp
*********************************************************************/

//## auto_generated
#include <oxf\omthread.h>
//## auto_generated
#include "NC_5.h"
//## event evB()
#include "Default.h"
//## package _7_NestedConditions

//## class NC_5
NC_5::NC_5(IOxfActive* theActiveContext) {
    setActiveContext(theActiveContext, false);
    initStatechart();
}

NC_5::~NC_5() {
}

int NC_5::getX() const {
    return x;
}

void NC_5::setX(int p_x) {
    x = p_x;
}

bool NC_5::startBehavior() {
    bool done = false;
    done = OMReactive::startBehavior();
    return done;
}

void NC_5::initStatechart() {
    rootState_subState = OMNonState;
    rootState_active = OMNonState;
    A_subState = OMNonState;
    C_subState = OMNonState;
}

void NC_5::rootState_entDef() {
    {
        A_entDef();
    }
}

IOxfReactive::TakeEventStatus NC_5::rootState_processEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    switch (rootState_active) {
        // State B
        case B:
        {
            res = B_handleEvent();
        }
        break;
        // State E
        case E:
        {
            if(IS_EVENT_TYPE_OF(evED_Default_id))
                {
                    A_subState = C;
                    C_subState = D;
                    rootState_active = D;
                    res = eventConsumed;
                }
            
            
        }
        break;
        default:
            break;
    }
    return res;
}

void NC_5::A_entDef() {
    rootState_subState = A;
    A_subState = B;
    rootState_active = B;
}

void NC_5::C_entDef() {
    A_subState = C;
    C_subState = C_B;
    rootState_active = C_B;
}

IOxfReactive::TakeEventStatus NC_5::B_handleEvent() {
    IOxfReactive::TakeEventStatus res = eventNotConsumed;
    if(IS_EVENT_TYPE_OF(evB_Default_id))
        {
            //## transition 3 
            if(x == 1)
                {
                    A_subState = C;
                    C_subState = C_B;
                    rootState_active = C_B;
                    res = eventConsumed;
                }
            else
                {
                    //## transition 5 
                    if( x == 2)
                        {
                            A_subState = C;
                            C_subState = D;
                            rootState_active = D;
                            res = eventConsumed;
                        }
                    else
                        {
                            //## transition 8 
                            if(x == 3)
                                {
                                    A_subState = E;
                                    rootState_active = E;
                                    res = eventConsumed;
                                }
                            else
                                {
                                    A_subState = B;
                                    rootState_active = B;
                                    res = eventConsumed;
                                }
                        }
                }
        }
    
    
    return res;
}

/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\NC_5.cpp
*********************************************************************/
