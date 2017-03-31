Marquette COSC 4400 - Compiler Construction


This repository contains all the work of John Halloran

Edsger Grammar 

{ Program }

program -> decl funs body EOF

{ DeclList }

decl -> [ decl_list ]

| ε

{ DeclList containing entries of type VarDecl }

decl_list -> ID : type

| decl_list , ID : type

{ All the following are subclasses of Type }

type -> int

| int ( NUM .. NUM ) array declaration

| bool

| bool ( NUM .. NUM )

{ FunList }

funs -> funs fundef

| ε

{ FunDef }

fundef -> fun opt_vlist << ID << opt_vlist ] decl body nuf

{ DeclList }

opt_vlist -> decl_list

| ε

{ StmtList }

body -> stmt

| body stmt

{ CompoundStmt }

stmt -> simple

| simple ; stmt

{ All the following are subclasses of Stmt }

simple -> destlist <- exprlist

| if glist fi

| if expr then stmt fi

| do glist od

| skip do nothing

| display exprlist

| funcall function with no return value



{ DestList containing entries of type Expr (Id or ArrayElt) }

destlist -> ID

| ID ( expr ) array element

| destlist , ID

| destlist , ID ( expr )

{ Guardlist }

glist -> gcommand

| glist [] gcommand

{ GCommand }

gcommand -> expr -> stmt

{ ExprList }

exprlist -> expr

| exprlist , expr

{ All the following are subclasses of Expr }

expr -> expr + expr

| expr - expr

| expr * expr

| expr / expr integer divide

| - expr

| ( expr )

| expr = expr

| expr <> expr not equal

| expr < expr

| expr <= expr

| expr > expr

| expr >= expr

| not expr

| expr and expr

| expr or expr

| true

| false

| NUMBER

| ID

| ID ( expr ) array element

| funcall

{ FunCall }

funcall -> ID << exprlist ]
