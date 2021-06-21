package idee;
import static idee.tokens.*;
%%
%class lexico
%type tokens
digito=[0-9]+
id =[a-z][a-z0-9]*
cml =[/][\*]([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*[\*][/]
cm = [/]+.*
simbolo=[+]|[-]|[\*]|[\/]|[\^]|[<]|<=|>|>=|==|!=|=|;|,|\(|\)|\{|\}
%{
    public String lexeme;
%}
%%
int |
if |
else |
do |
until |
do |
fi |
while |
read |
write |
float |
bool |
not |
and |
or |
program |
while {lexeme=yytext(); return reservadas;}
{cml} {return MLCM;}
{cm} {return CM;}
{id} {return IDENT;}
{digito}+ {return INT;}
{digito}+"."{digito}+ {return FLOAT;}
{simbolo} {return RES_SYMBOL;}
. {return error}


