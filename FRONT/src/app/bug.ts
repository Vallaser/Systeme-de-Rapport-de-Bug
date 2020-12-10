
export interface Bug {
  comment: [{
      comment: string;
      dateComment: Date;
    id_bug: BigInteger;
    id_comment: BigInteger;
    id_developer: BigInteger;
    }];
  dateCreation: Date;
  description: string;
  etat: string;
  id_bug: BigInteger;
  id_developer: BigInteger;
  priority: string;
  title: string;
}
